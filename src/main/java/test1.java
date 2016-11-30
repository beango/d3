import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class test1 {

	@Test
	public void test() {
		System.out.println(getCurTime("YYYY-MM-DD HH:MM:SS WW"));
		fail("Not yet implemented");
	}

	public String getCurTime(String sFormat){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        String today = null;
        if (day == 2) {
            today = "一";
        } else if (day == 3) {
            today = "二";
        } else if (day == 4) {
            today = "三";
        } else if (day == 5) {
            today = "四";
        } else if (day == 6) {
            today = "五";
        } else if (day == 7) {
            today = "六";
        } else if (day == 1) {
            today = "日";
        }

        return sFormat.replace("YYYY", calendar.get(Calendar.YEAR) + "")
                .replace("MM", (calendar.get(Calendar.MONTH)+1) + "")
                .replace("DD", calendar.get(Calendar.DAY_OF_MONTH)+ "")
                .replace("HH", calendar.get(Calendar.HOUR_OF_DAY) + "")
                .replace("MI", calendar.get(Calendar.MINUTE) + "")
                .replace("SS", calendar.get(Calendar.SECOND) + "")
                .replace("WW", "周" + today + "")
        ;
    }
	
}
