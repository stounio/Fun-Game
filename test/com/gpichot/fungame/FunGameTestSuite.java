package com.gpichot.fungame;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.gpichot.fungame.factory.GamePlayOptionFactoryTest;
import com.gpichot.fungame.factory.GenericObjectFactoryTest;
import com.gpichot.fungame.game.manager.GamePlayOptionManagerTest;
import com.gpichot.fungame.game.om.GamePlayOptionTest;
import com.gpichot.fungame.game.service.GamePlayProcessingTest;
import com.gpichot.fungame.game.service.GamePlayServiceTest;
import com.gpichot.fungame.ui.service.ResourceServiceTest;

@RunWith(Suite.class)
@SuiteClasses({
        GamePlayOptionFactoryTest.class, GenericObjectFactoryTest.class, GamePlayOptionManagerTest.class,
        GamePlayOptionTest.class, GamePlayProcessingTest.class, GamePlayServiceTest.class, ResourceServiceTest.class
})
public class FunGameTestSuite {

}
