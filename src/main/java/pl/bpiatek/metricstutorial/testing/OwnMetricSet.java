package pl.bpiatek.metricstutorial.testing;

import com.codahale.metrics.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.glowroot.agent.api.Instrumentation;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bartosz Piatek on 21/10/2021
 */
@Component
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class OwnMetricSet implements MetricSet {

  private final MemoryMXBean mxBean;

  public OwnMetricSet() {
    this(ManagementFactory.getMemoryMXBean());
  }

  @Instrumentation.Timer("dupa")
  @Override
  public Map<String, Metric> getMetrics() {
    Map<String, Metric> gauges = new HashMap();

    gauges.put("heap.init", (Gauge<Long>) () -> mxBean.getHeapMemoryUsage().getInit());
    gauges.put("heap.used", (Gauge<Long>) () -> mxBean.getHeapMemoryUsage().getUsed());
    gauges.put("heap.max", (Gauge<Long>) () -> mxBean.getHeapMemoryUsage().getMax());
    gauges.put("heap.committed", (Gauge<Long>) () -> mxBean.getHeapMemoryUsage().getCommitted());
    gauges.put("heap.usage", new RatioGauge() {
      @Override
      protected Ratio getRatio() {
        final MemoryUsage usage = mxBean.getHeapMemoryUsage();
        return Ratio.of(usage.getUsed(), usage.getMax());
      }
    });
    return gauges;
  }
}
