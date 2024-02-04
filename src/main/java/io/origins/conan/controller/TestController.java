package io.origins.conan.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.threads.TaskQueue;
import org.apache.tomcat.util.threads.TaskThreadFactory;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    public static void main(String[] args) throws InterruptedException {
        String namePrefix = "歪歪歪-exec-";
        boolean daemon = true;
        TaskQueue taskqueue = new TaskQueue(300);
        TaskThreadFactory tf = new TaskThreadFactory(namePrefix, daemon, Thread.NORM_PRIORITY);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                150, 60000, TimeUnit.MILLISECONDS, taskqueue, tf);
        taskqueue.setParent(executor);
        for (int i = 0; i < 300; i++) {
            try {
                executor.execute(() -> {
                    logStatus(executor, "创建任务");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Thread.currentThread().join();
    }

    private static void logStatus(ThreadPoolExecutor executor, String name) {
        TaskQueue queue = (TaskQueue) executor.getQueue();
        System.out.println(Thread.currentThread().getName() + "-" + name + "-:" +
                "核心线程数:" + executor.getCorePoolSize() +
                "\t活动线程数:" + executor.getActiveCount() +
                "\t最大线程数:" + executor.getMaximumPoolSize() +
                "\t总任务数:" + executor.getTaskCount() +
                "\t当前排队线程数:" + queue.size() +
                "\t队列剩余大小:" + queue.remainingCapacity());
    }

    @GetMapping("/hello")
    @Cacheable("hello")
    public String hello() throws ExecutionException, InterruptedException {
        // 创建一个CompletableFuture，表示最终的结果
        CompletableFuture<Void> finalResult = new CompletableFuture<>();

        // 模拟一些异步操作
        CompletableFuture<Void> subTask1 = CompletableFuture.runAsync(() -> {
            // 子线程1的逻辑
            System.out.println("SubTask1 completed");
        });

        CompletableFuture<Void> subTask2 = CompletableFuture.runAsync(() -> {
            // 子线程2的逻辑
            System.out.println("SubTask2 completed");
        });

        CompletableFuture<Void> subTask3 = CompletableFuture.runAsync(() -> {
            // 子线程3的逻辑
            System.out.println("SubTask3 completed");
            // 睡眠 30秒
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 将所有子任务组合在一起
        CompletableFuture<Void> allOf = CompletableFuture.allOf(subTask1, subTask2, subTask3);

        // 当所有子任务完成时，触发最终处理
        allOf.thenRun(() -> {
            // 这里可以进行最终的处理，比如聚合子任务的结果
            System.out.println("All subtasks completed");

            // 将最终结果设置到CompletableFuture中
            finalResult.complete(null);
        });

        // 等待最终结果
        finalResult.get();
        System.out.println("Final Result: All tasks completed");
        return "Hello World!";
    }
}
