package com.telran.scheduler.tests;

import com.telran.scheduler.model.Event;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EventCreationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if (!app.getEvent().isContainerReportPresent()){
            app.getUser().defaultLogin();
        }
    }
    @Test
    public void createEventPositiveTest()  {
        int quantityBeforeAdd;
        int quantityAfterAdd;
        quantityBeforeAdd = app.getEvent().getTotalEvents();
        // tap on Plus Button
        app.getEvent().tapOnPlusButton();
        // tap on Pencil
        app.getEvent().tapOnPencil();
        //fill EventForm
        app.getEvent().fillEventCreationForm(new Event().setEventTitle("Event")
                .setEventType("1").setBreaks(2).setWage("150"));
        //confirm Event creation
        app.getEvent().tapOnAddEventButton();
        quantityAfterAdd = app.getEvent().getTotalEvents();
        Assert.assertEquals(quantityAfterAdd,quantityBeforeAdd+1);
        //assert    isEventPresent


    }
}