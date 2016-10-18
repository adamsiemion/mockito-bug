Creating a mock of `org.kohsuke.github.GHIssue` (https://github.com/kohsuke/github-api version 1.77) causes Mockito to fail despite this class is public and non-final.

    org.mockito.exceptions.base.MockitoException: 
    Mockito cannot mock this class: class org.kohsuke.github.GHIssue.

    Mockito can only non-private & non-final classes.
    If you're not sure why you're getting this error, please report to the mailing list.
        
    Java               : 1.8
    JVM vendor name    : Oracle Corporation
    JVM vendor version : 25.101-b13
    JVM name           : Java HotSpot(TM) 64-Bit Server VM
    JVM version        : 1.8.0_101-b13
    JVM info           : mixed mode
    OS name            : Mac OS X
    OS version         : 10.11.6
    
    
    Underlying exception : java.lang.IllegalArgumentException: Cannot cast to primitive type: void
    
        at com.siemion.mockito.AppTest.test(AppTest.java:12)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:47)
        at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
        at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:44)
        at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
        at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:271)
        at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:70)
        at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:50)
        at org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)
        at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)
        at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)
        at org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)
        at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)
        at org.junit.runners.ParentRunner.run(ParentRunner.java:309)
        at org.junit.runner.JUnitCore.run(JUnitCore.java:160)
        at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:69)
        at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:234)
        at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:74)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)
    Caused by: java.lang.IllegalArgumentException: Cannot cast to primitive type: void
        at net.bytebuddy.implementation.bytecode.assign.TypeCasting.to(TypeCasting.java:39)
        at net.bytebuddy.dynamic.scaffold.TypeWriter$MethodPool$Record$AccessBridgeWrapper.apply(TypeWriter.java:1100)
        at net.bytebuddy.dynamic.scaffold.TypeWriter$Default$ForCreation.create(TypeWriter.java:3802)
        at net.bytebuddy.dynamic.scaffold.TypeWriter$Default.make(TypeWriter.java:1618)
        at net.bytebuddy.dynamic.scaffold.subclass.SubclassDynamicTypeBuilder.make(SubclassDynamicTypeBuilder.java:172)
        at net.bytebuddy.dynamic.scaffold.subclass.SubclassDynamicTypeBuilder.make(SubclassDynamicTypeBuilder.java:153)
        at net.bytebuddy.dynamic.DynamicType$Builder$AbstractBase.make(DynamicType.java:2568)
        at net.bytebuddy.dynamic.DynamicType$Builder$AbstractBase$Delegator.make(DynamicType.java:2670)
        at org.mockito.internal.creation.bytebuddy.SubclassBytecodeGenerator.mockClass(SubclassBytecodeGenerator.java:80)
        at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator$CachedBytecodeGenerator.getOrGenerateMockClass(TypeCachingBytecodeGenerator.java:87)
        at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator.mockClass(TypeCachingBytecodeGenerator.java:34)
        at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMockType(SubclassByteBuddyMockMaker.java:64)
        at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMock(SubclassByteBuddyMockMaker.java:35)
        at org.mockito.internal.creation.bytebuddy.ByteBuddyMockMaker.createMock(ByteBuddyMockMaker.java:22)
        at org.mockito.internal.util.MockUtil.createMock(MockUtil.java:35)
        at org.mockito.internal.MockitoCore.mock(MockitoCore.java:63)
        at org.mockito.Mockito.mock(Mockito.java:1629)
        at org.mockito.Mockito.mock(Mockito.java:1542)
        ... 27 more

and creating a mock of `org.kohsuke.github.GHRepository` results in:

    java.lang.VerifyError: Bad type on operand stack
    Exception Details:
      Location:
        org/kohsuke/github/GHRepository$MockitoMock$667330966.getId()Ljava/lang/String; @4: checkcast
      Reason:
        Type integer (current frame, stack[0]) is not assignable to 'java/lang/Object'
      Current Frame:
        bci: @4
        flags: { }
        locals: { 'org/kohsuke/github/GHRepository$MockitoMock$667330966' }
        stack: { integer }
      Bytecode:
        0x0000000: 2ab6 003d c000 2eb0                    


        at sun.reflect.GeneratedSerializationConstructorAccessor1.newInstance(Unknown Source)
        at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
        at org.objenesis.instantiator.sun.SunReflectionFactoryInstantiator.newInstance(SunReflectionFactoryInstantiator.java:45)
        at org.objenesis.ObjenesisBase.newInstance(ObjenesisBase.java:73)
        at org.mockito.internal.creation.instance.ObjenesisInstantiator.newInstance(ObjenesisInstantiator.java:14)