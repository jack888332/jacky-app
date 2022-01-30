package demo.collection;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TestedCalendar {
	private Calendar myTime;

	public static void main(String[] args) {
		TestedCalendar tc = new TestedCalendar();
		tc.showInfo();
	}

	public void showInfo() {
		myTime = Calendar.getInstance();
//		System.out.println(myTime.getCalendarType());		
//		System.out.println(myTime.getTimeZone());
//		System.out.println(myTime.getWeekYear());
//		System.out.println(myTime.getWeeksInWeekYear());
		System.out.println(myTime.getTime());
		System.out.println(myTime.getTime().getTime() + "毫秒");
//		
//		// 以下与天相关
//		System.out.println(myTime.get(Calendar.DAY_OF_MONTH));
//		System.out.println(myTime.get(Calendar.DAY_OF_WEEK));
//		System.out.println(myTime.get(Calendar.DAY_OF_WEEK_IN_MONTH));
//		System.out.println(myTime.get(Calendar.DAY_OF_YEAR));
//
//		System.out.println(myTime.get(Calendar.ERA));
//		System.out.println(myTime.get(Calendar.YEAR));
//		System.out.println(myTime.get(Calendar.MONTH));
//		System.out.println(myTime.get(Calendar.DATE));
//		System.out.println(myTime.get(Calendar.AM_PM));
//		System.out.println(myTime.get(Calendar.HOUR));
//		System.out.println(myTime.get(Calendar.MINUTE));
//		System.out.println(myTime.get(Calendar.SECOND));
//		System.out.println(myTime.get(Calendar.MILLISECOND));

//		DateFormat df;
//		df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, new Locale("zh", "CN"));
//		System.out.println(df.format(myTime.getTime()));
//		df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, new Locale("zh", "TW"));
//		System.out.println(df.format(myTime.getTime()));

		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd kk:mm:ss:SSS", new Locale("zh", "CN"));
		System.out.println(sdf.format(myTime.getTime()));
		System.out.println(myTime.isWeekDateSupported());
		System.out.println(myTime.isLenient());
		

//		df = DateFormat.getDateInstance();
//		System.out.println(df.format(myTime.getTime()));
//
//		df = DateFormat.getInstance();
//		System.out.println(df.format(myTime.getTime()));

//		for (Locale l4e : Calendar.getAvailableLocales()) {
//			System.out.println(
//				l4e.getDisplayCountry() + " # " + 
//				l4e.getDisplayLanguage() + " # " + 
//				l4e.getDisplayName() + " # " + 	
//				l4e.getDisplayScript()  + " # " + 
//				l4e.getDisplayVariant()
//			);
//		}

//		for (String act : Calendar.getAvailableCalendarTypes()) {
//			System.out.println(act);
//		}
	}

}
