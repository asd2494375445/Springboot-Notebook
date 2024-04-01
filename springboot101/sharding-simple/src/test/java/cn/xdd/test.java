package cn.xdd;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

@SpringBootTest
@Slf4j
public class test {
    private void tes(){
        ThreadFactory guavaThreadFactory = new ThreadFactoryBuilder().setNameFormat("retryClient-pool-").build();


        ExecutorService exec = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10),guavaThreadFactory );
        exec.submit(() -> {
                    log.info("--记忆中的颜色是什么颜色---");
                }
        );
    }


}
