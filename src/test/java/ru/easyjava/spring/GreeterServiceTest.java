package ru.easyjava.spring;

import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GreeterServiceTest {
    @Rule
    public EasyMockRule em = new EasyMockRule(this);

    @Mock
    private TargetService targetService;

    @TestSubject
    private GreeterService testedObject = new GreeterService();

    @Test
    public void testGreet() {
        expect(targetService.getTarget()).andStubReturn("TEST");
        replay(targetService);

        assertThat(testedObject.greet(), is("Hello TEST!"));
    }
}