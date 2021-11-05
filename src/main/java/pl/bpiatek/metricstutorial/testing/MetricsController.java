package pl.bpiatek.metricstutorial.testing;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bartosz Piatek on 21/10/2021
 */
@RestController
@RequestMapping("")
@AllArgsConstructor
class MetricsController {

  private final NewScheduler scheduler;
//  private final MetricRegistry metricRegistry;

//  MetricsController(MetricRegistry metricRegistry) {
//    this.metricRegistry = metricRegistry;
//    this.ownReporter = OwnReporter.forRegistry(metricRegistry);
//  }

  @GetMapping("/start")
  void start() throws Exception {
    scheduler.dupa();
  }

  @GetMapping("/stop")
  void stop() throws Exception {
//    scheduler.shutDown();
  }
}
