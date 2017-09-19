package edu.matc.taglibdemo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;

public class GreetingMessageTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter fmtDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter fmtTime = DateTimeFormatter.ofPattern("hh:mm:ss");

        out.println("Today's current local date is: " + fmtDate.format(localDateTime));
        out.println("<br/>");
        out.print("Current local time is: " + fmtTime.format(localDateTime));
        out.println("<br/>");

        if (localDateTime.getMonthValue() == 10
                && localDateTime.getDayOfMonth() == 31) {
            out.println("Happy Holloween!!!");
        } else if (localDateTime.getMonthValue() <= 10
                && localDateTime.getDayOfMonth() < 31) {
            LocalDate holloween = LocalDate.of(2017, Month.OCTOBER, 31);
            out.println(localDateTime.toLocalDate().until(holloween, ChronoUnit.DAYS)
                    + " days till Holloween!");
        }
    }
}
