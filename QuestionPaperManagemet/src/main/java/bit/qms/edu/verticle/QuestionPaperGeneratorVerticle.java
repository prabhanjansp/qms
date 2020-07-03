package bit.qms.edu.verticle;

import bit.qms.edu.model.QuestionPaperModel;
import bit.qms.edu.paper.ExternalPaperGenerator;
import bit.qms.edu.paper.InternalPaperGenerator;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.Json;

/**
 * 
 * @author puran
 *
 */
public class QuestionPaperGeneratorVerticle extends AbstractVerticle {

	@Override
	public void start(Future<Void> startFuture) throws Exception {
		vertx.eventBus().consumer("generate").handler(handler -> {
			String msg = (String) handler.body();
			QuestionPaperModel model = Json.decodeValue(msg, QuestionPaperModel.class);
			System.out.println("Received request for paper generation for file Id :" + model.getFileId());

			if (model.getQpType().equalsIgnoreCase("internal")) {
				InternalPaperGenerator generator = new InternalPaperGenerator();
				generator.generate(model);
			} else {
				ExternalPaperGenerator generator = new ExternalPaperGenerator();
				generator.generate(model);
			}

		});

		startFuture.complete();
	}

}
