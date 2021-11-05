package pl.bpiatek.metricstutorial.testing;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * Created by Bartosz Piatek on 04/11/2021
 */
@Component
@RequiredArgsConstructor
class NewScheduler {

  private final OwnReporter ownReporter;

  ScheduledThreadPoolExecutor scheduler = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);

  public void dupa( ) {
    scheduler.scheduleAtFixedRate(ownReporter, 0, 2000, TimeUnit.SECONDS);
  }
}
