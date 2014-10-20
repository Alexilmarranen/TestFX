/*
 * Copyright 2013-2014 SmartBear Software
 *
 * Licensed under the EUPL, Version 1.1 or - as soon they will be approved by the European
 * Commission - subsequent versions of the EUPL (the "Licence"); You may not use this work
 * except in compliance with the Licence.
 *
 * You may obtain a copy of the Licence at:
 * http://ec.europa.eu/idabc/eupl
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * Licence is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the Licence for the specific language governing permissions
 * and limitations under the Licence.
 */
package org.loadui.testfx.robots.impl;

import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.robots.MouseRobot;
import org.loadui.testfx.robots.ScrollRobot;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ScrollRobotImplTest {

    //---------------------------------------------------------------------------------------------
    // FIELDS.
    //---------------------------------------------------------------------------------------------

    public ScrollRobot scrollRobot;

    public MouseRobot mouseRobot;

    //---------------------------------------------------------------------------------------------
    // FIXTURE METHODS.
    //---------------------------------------------------------------------------------------------

    @Before
    public void setup() {
        mouseRobot = mock(MouseRobot.class);
        scrollRobot = new ScrollRobotImpl(mouseRobot);
    }

    //---------------------------------------------------------------------------------------------
    // FEATURE METHODS.
    //---------------------------------------------------------------------------------------------

    @Test
    public void scrollUp() {
        // when:
        scrollRobot.scrollUp(5);

        // then:
        verify(mouseRobot, times(5)).scroll(eq(-1));
    }

    @Test
    public void scrollDown() {
        // when:
        scrollRobot.scrollDown(5);

        // then:
        verify(mouseRobot, times(5)).scroll(eq(1));
    }

}