package io.origins.conan.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

enum TaskStatus {
    WAIT, RUNNING, FAIL, SUCCESS
}

class Task {
    private final List<CompletableFuture<TaskStatus>> subtasks = new ArrayList<>();

    public void addSubtask(CompletableFuture<TaskStatus> subtask) {
        subtasks.add(subtask);
    }

    public CompletableFuture<TaskStatus> run() {
        CompletableFuture<TaskStatus> future = new CompletableFuture<>();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(
                subtasks.toArray(new CompletableFuture[0])
        );

        allOf.thenRun(() -> {
            for (CompletableFuture<TaskStatus> subtask : subtasks) {
                try {
                    if (subtask.get() == TaskStatus.FAIL) {
                        future.complete(TaskStatus.FAIL);
                        return;
                    }
                } catch (InterruptedException | ExecutionException e) {
                    future.completeExceptionally(e);
                    return;
                }
            }
            future.complete(TaskStatus.SUCCESS);
        });

        return future;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Task task = new Task();
        CompletableFuture<TaskStatus> subtask1 = CompletableFuture.completedFuture(TaskStatus.SUCCESS);
        CompletableFuture<TaskStatus> subtask2 = CompletableFuture.completedFuture(TaskStatus.FAIL);
        CompletableFuture<TaskStatus> subtask3 = CompletableFuture.completedFuture(TaskStatus.SUCCESS);

        task.addSubtask(subtask1);
        task.addSubtask(subtask2);
        task.addSubtask(subtask3);

        CompletableFuture<TaskStatus> mainTask = task.run();
        mainTask.thenAccept(status -> System.out.println("Main task status: " + status));
    }
}
