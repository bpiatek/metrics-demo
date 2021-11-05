package pl.bpiatek.metricstutorial.testing;

import com.google.common.util.concurrent.AbstractScheduledService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by Bartosz Piatek on 04/11/2021
 */
@Component
@RequiredArgsConstructor
class ReposringScheduler extends AbstractScheduledService {

  private final OwnReporter ownReporter;
//  private final ThreadPoolTaskScheduler taskScheduler;

//  ReposringScheduler(OwnReporter ownReporter, ThreadPoolTaskScheduler taskScheduler) {
//    this.ownReporter = ownReporter;
//    this.taskScheduler = taskScheduler;
//  }
//
//  public void runSchedule() {
//    taskScheduler.scheduleAtFixedRate(ownReporter, 2000);
//  }


  @Override
  protected void runOneIteration() throws Exception {
    ownReporter.run();
  }

  @Override
  protected Scheduler scheduler() {
    return Scheduler.newFixedRateSchedule(0, 3, TimeUnit.SECONDS);
  }

  @Override
  protected void startUp() throws Exception {
    super.startUp();
  }

  @Override
  protected void shutDown() throws Exception {
    super.shutDown();
  }
}
