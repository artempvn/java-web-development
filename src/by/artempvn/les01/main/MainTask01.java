package by.artempvn.les01.main;

import java.util.Scanner;

import by.artempvn.les01.console.ConsoleOutput;
import by.artempvn.les01.entity.Point2D;
import by.artempvn.les01.exception.CustomException;
import by.artempvn.les01.parser.ParserNumber;
import by.artempvn.les01.service.ServiceCalendar;
import by.artempvn.les01.service.ServiceDigit;
import by.artempvn.les01.service.ServiceFunction;
import by.artempvn.les01.service.ServicePoint;
import by.artempvn.les01.service.ServiceSquareCircle;
import by.artempvn.les01.service.ServiceTime;
import by.artempvn.les01.validator.CheckType;

public class MainTask01 {
	static String s;

	public static void main(String[] args) throws CustomException {
		ServiceFunction t=new ServiceFunction();
		double[][] d=t.calculateFunctionTask10Interval(-1, 10,2.5);
		

		ConsoleOutput c=new ConsoleOutput();
		c.printFunctionTask10Interval(d);


	}

}
