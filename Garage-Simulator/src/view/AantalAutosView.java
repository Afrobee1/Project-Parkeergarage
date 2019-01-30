/**
 * 
 */
package view;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import model.SimulatorModel;

/**
 * @author eyads
 *
 */
public class AantalAutosView extends PieChart {
	private ObservableList<PieChart.Data> pieChartData;
	private SimulatorModel model;

	public AantalAutosView(SimulatorModel model) {
		super();
		this.model = model;
//			 pieChartData =
//		             FXCollections.observableArrayList(
//		             new PieChart.Data("Grapefruit", 13),
//		             new PieChart.Data("Oranges", 25),
//		             new PieChart.Data("Plums", 10),
//		             new PieChart.Data("Pears", 22),
//		             new PieChart.Data("Apples", 30));

		setTitle("Auto's in de garage");

		AnimationTimer d = new AnimationTimer() {
			private long lastUpdate = 0;

			@Override
			public void handle(long now) {
				if (now - lastUpdate >= 1000_000) {
					lastUpdate = now;
                
					 if(model.isIsrunning()) {

					     

					pieChartData = FXCollections.observableArrayList(new PieChart.Data("AdHoc", model.getNumberOfAdHocCar()),
							new PieChart.Data("Pass", model.getNumberOfParkingPassCar()), new PieChart.Data("Resereveren", model.getNumberOfReserverenCar())
							);
					setAnimated(false);
					setData(pieChartData);

				}
			}}
		};
		d.start();
	}
	
}
