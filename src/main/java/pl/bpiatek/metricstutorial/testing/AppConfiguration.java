package pl.bpiatek.metricstutorial.testing;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Bartosz Piatek on 21/10/2021
 */
@Configuration
class AppConfiguration {

  @Bean
  MetricRegistry metricRegistry() {
    final MetricRegistry metricRegistry = new MetricRegistry();
    metricRegistry.register("", new OwnMetricSet());
    return metricRegistry;
  }

  @Bean
  HealthCheckRegistry healthCheckRegistry() {
    return new HealthCheckRegistry();
  }

//  @Bean
//  OwnReporter ownReporter(MetricRegistry metricRegistry) {
//    return OwnReporter.forRegistry(metricRegistry);
//  }

}
