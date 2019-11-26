package edu.cst.application.dev.midterm.shanjida;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class PayCheckController {

	@FXML
	private FlowPane fpLayout;

	@FXML
	private Button btnCalculate, btnReset;

	@FXML
	private TextField inputHrsWorked, inputHrlyWage;

	@FXML
	private TextField regularhrs, regularPay, 
					  overTimePay, overTimehrs, 
					  weeklyPay, yearlySalary, 
					  marginalTax, netSalary;
	
	@FXML
	void calculateSalary(ActionEvent event) {
		Double totalHrs = Double.parseDouble(inputHrsWorked.getText());
		Double wage = Double.parseDouble(inputHrlyWage.getText());

		Double overTimehr = totalHrs - 40;		
		Double ovrTimePay = overTimehr * (wage * 1.5);

		Double regHours = totalHrs;
		Double regPay = regHours * wage;
		
		Double wklyPay = regPay;
		Double overTimewklyPay = regPay + ovrTimePay;
		
		Double totalPay = wklyPay + overTimewklyPay;
		Double yrlySalary = totalPay * 52;
		
		
		Double mTax;
		Double nSalary;

		if (totalHrs > 40) {
			overTimehrs.setText(overTimehr + ""); 
			regularhrs.setText("40");
			regularPay.setText(regPay + "");
			overTimePay.setText(ovrTimePay + "");
			weeklyPay.setText(overTimewklyPay + "");
			yearlySalary.setText(yrlySalary + "");

		} else if (totalHrs < 41) {
			
			overTimehrs.setText("N/A"); 
			overTimePay.setText("N/A");
			regularhrs.setText(totalHrs+ "");
			regularPay.setText(regPay  +"");
			weeklyPay.setText(wklyPay + "");
			yearlySalary.setText(wklyPay * 52 + "");
		}

		if (yrlySalary >= 0 && yrlySalary <= 9699.999) {
			mTax = 0.1 * yrlySalary;
			nSalary = yrlySalary - mTax;

			marginalTax.setText(mTax + "");
			netSalary.setText(nSalary + "");

		}

		else if (yrlySalary >= 9700  && yrlySalary <= 39474.999) {
			mTax = 0.12 * yrlySalary;
			nSalary = yrlySalary - mTax;

			marginalTax.setText(mTax + "");
			netSalary.setText(nSalary + "");

		}
		else if (yrlySalary >= 39475 && yrlySalary <= 84199.999) {
			mTax = 0.22 * yrlySalary;
			nSalary = yrlySalary - mTax;

			marginalTax.setText(mTax + "");
			netSalary.setText(nSalary + "");

		}
		else if (yrlySalary >= 84200 && yrlySalary <= 160724.999) {
			mTax = 0.24 * yrlySalary;
			nSalary = yrlySalary - mTax;

			marginalTax.setText(mTax + "");
			netSalary.setText(nSalary + "");

		}
		else if (yrlySalary >= 160725 && yrlySalary <= 20499.999) {
			mTax = 0.32 * yrlySalary;
			nSalary = yrlySalary - mTax;

			marginalTax.setText(mTax + "");
			netSalary.setText(nSalary + "");

		}
		else if (yrlySalary >= 204100 && yrlySalary <= 510329.999) {
			mTax = 0.35 * yrlySalary;
			nSalary = yrlySalary - mTax;

			marginalTax.setText(mTax + "");
			netSalary.setText(nSalary + "");

		}
		else if (yrlySalary >= 510300) {
			mTax = 0.37 * yrlySalary;
			nSalary = yrlySalary - mTax;

			marginalTax.setText(mTax + "");
			netSalary.setText(nSalary + "");

		}
		else {
			mTax = yrlySalary;
			nSalary = yrlySalary;
		
			marginalTax.setText(mTax + "");
			netSalary.setText(nSalary + "");
		}
		
	}

	@FXML
	void resetAll(ActionEvent event) {
		inputHrsWorked.clear();
		inputHrlyWage.clear();
		overTimehrs.clear();
		regularhrs.clear();
		overTimePay.clear();
		regularPay.clear();
		weeklyPay.clear();
		yearlySalary.clear();
		marginalTax.clear();
		netSalary.clear();
	}

}
