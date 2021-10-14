# Issue with Kotlin Multiplatform and `module-info.java`

Either I'm doing something wrong or there's an issue with Kotlin multiplatform projects **without** Java code. It seems that you can't export the package your Kotlin classes reside unless you **do** have at least a Java class in that package. It doesn't need to have anything and its visibility can be just package-level,though

## Project explanation

There's a [Kotlin mpp module](./mpp) that is used by a [Kotlin jvm module](./jvm)

Currently, you can run the jvm app with

```shell
$ ./gradlew clean build
...
BUILD SUCCESSFUL in 2s

$ ./gradlew run
...
> Task :jvm:run
Demo(mpp=Mpp(value=mpp))

BUILD SUCCESSFUL in 1s
```

If you remove the java class and run again, the build process will fail

```shell
$ rm mpp/src/jvmMain/java/com/example/mpp/IdeallyShouldNotExist.java
$ ./gradlew clean build
...
> Task :mpp:compileJava FAILED
$PathToThisProject/mpp/src/jvmMain/java/module-info.java:3: error: package is empty or does not exist: com.example.mpp
    exports com.example.mpp;
                       ^
1 error

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':mpp:compileJava'.
```

You can recreate the empty class again with
```shell
$ mv EmptyJavaClass.java ./mpp/src/jvmMain/java/com/example/mpp/
```