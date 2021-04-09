package com.lly.demo.service;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

@Service
public class ThreadPoolService {

    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
            5,
            1L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(3),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 模拟用线程池发邮件的需求
     *
     * @param set
     */
    public void sendWarningEmail(Set<String> set) {
        System.out.println(threadPoolExecutor.toString());
        Future<List<String>> future = threadPoolExecutor.submit(new WarningEmailThread(set));
        try {
            List<String> strings = future.get();
            System.out.println("返回的结果：" + strings);
//            threadPoolExecutor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private class WarningEmailThread implements Callable<List<String>> {
        private Set<String> ssids;

        public WarningEmailThread(Set<String> ssids) {
            this.ssids = ssids;
        }

        @Override
        public List<String> call() throws Exception {
            List<String> result = Lists.newArrayList();
            for (String ssid : ssids) {
                if (sendEmail(ssid)) {
                    result.add(ssid);
                }
            }
            return result;
        }

        private boolean sendEmail(String ssid) {
            try {
                System.out.println(Thread.currentThread().getId() + "发送邮件成功，ssid=" + ssid);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

}
