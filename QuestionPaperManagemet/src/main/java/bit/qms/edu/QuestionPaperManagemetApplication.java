package bit.qms.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import bit.qms.edu.verticle.QMSWorkerVerticle;
import bit.qms.edu.verticle.QuestionPaperGeneratorVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

@SpringBootApplication
public class QuestionPaperManagemetApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionPaperManagemetApplication.class, args);
	}
	
	@EventListener
	public void deployVerticles(ApplicationReadyEvent event) {

		Vertx vertx = Vertx.vertx();
		
		DeploymentOptions deploymentOptions = new DeploymentOptions();
		deploymentOptions.setInstances(4);
		deploymentOptions.setWorker(true);
		vertx.deployVerticle(QMSWorkerVerticle.class.getName(), deploymentOptions ,completionHandler -> {
			if (completionHandler.succeeded()) {
				System.out.println("WorkerVerticle successfully deployed");
			} else {
				System.err.println("Error while deploying WorkerVerticle " + completionHandler.toString());
			}
		});
		
		vertx.deployVerticle(QuestionPaperGeneratorVerticle.class.getName(),deploymentOptions , handler -> {
			if (handler.succeeded()) {
				System.out.println("Eventbus verticle successfully deployed");
			} else {
				System.err.println("Error while deploying Eventbus Verticle " + handler.toString());
			}
		});
	}

}
