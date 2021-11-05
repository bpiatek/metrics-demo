package pl.bpiatek.metricstutorial.testing;

import org.springframework.stereotype.Component;

import java.util.TimerTask;

/**
 * Created by Bartosz Piatek on 21/10/2021
 */
@Component
class OwnReporter extends TimerTask {

  private volatile boolean shutdown;

  @Override
  public void run() {
    while(!shutdown) {
      System.out.println("COS RAPORTUJE");
    }
  }

  public void shutdown() {
    shutdown = true;
  }

  public void start() {
    shutdown = false;
  }



//    extends ScheduledReporter {
//
//  protected OwnReporter(
//      MetricRegistry registry,
//      String name,
//      MetricFilter filter,
//      TimeUnit rateUnit,
//      TimeUnit durationUnit
//  ) {
//    super(registry, name, filter, rateUnit, durationUnit, null, true);
//  }
//
//  static OwnReporter forRegistry(MetricRegistry registry) {
//    return new OwnReporter(registry, "dupa", MetricFilter.ALL, TimeUnit.SECONDS, TimeUnit.MILLISECONDS);
//  }

//  @Override
//  public void report(
//      SortedMap<String, Gauge> gauges,
//      SortedMap<String, Counter> counters,
//      SortedMap<String, Histogram> histograms,
//      SortedMap<String, Meter> meters,
//      SortedMap<String, Timer> timers
//  ) {
//    System.out.println("COS RAPORTUJE");
//  }
}
