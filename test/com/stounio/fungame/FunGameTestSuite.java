package com.stounio.fungame;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.stounio.fungame.factory.GamePlayOptionFactoryTest;
import com.stounio.fungame.factory.GenericObjectFactoryTest;
import com.stounio.fungame.game.manager.GamePlayOptionManagerTest;
import com.stounio.fungame.game.om.GamePlayOptionTest;
import com.stounio.fungame.game.service.GamePlayProcessingTest;
import com.stounio.fungame.game.service.GamePlayServiceTest;
import com.stounio.fungame.ui.service.ResourceServiceTest;

@RunWith(Suite.class)
@SuiteClasses({
        GamePlayOptionFactoryTest.class, GenericObjectFactoryTest.class, GamePlayOptionManagerTest.class,
        GamePlayOptionTest.class, GamePlayProcessingTest.class, GamePlayServiceTest.class, ResourceServiceTest.class
})
public class FunGameTestSuite {

}
