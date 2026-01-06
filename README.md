# Maven Java project template

Personal project template for Java project using Maven, and JUnit 6 for testing. Launch configs for VSCode and IntelliJ are provided. The project is configured for Java 21 by default.

## Project structure

Normal Maven structure

```
├─ src/
│  ├─ main/
│  │  ├─ java/       < Source code
│  │  └─ resources/  < Non-code assets (images, sounds, etc)
│  └─ tests/
│     ├─ java/       < Tests
│     └─ resources/  < Non-code assets for tests
├─ target/           < Output for .class & .jar
├─ .idea/            < IntelliJ configs
├─ .vscode/          < VSCode configs
├─ .gitignore        < Files ignored by git
└─ pom.xml           < Maven configuration
```

## Launch configurations

The project can be run with assertions on/off, and can be run from the source or the JAR. This makes 4 run configurations.

As the name implies, "assertions on" makes it so that [`assert` statements are evaluated](https://docs.oracle.com/javase/8/docs/technotes/guides/language/assert.html), whereas "assertions off" causes the JVM to completely ignore them. This gives us the option to have a sort of "debug" mode and "release" mode.

The choice to run from source or JAR is kinda whatever, running from source is probably the preferable option most of the time. The option to run from JAR is there to facilitate ensuring that the JAR can be built correctly, and that it functions correctly.

Although probably obvious, the names for the launch configurations are:

<table>
<thead>
    <tr>
        <td>—</td>
        <td>Assertions enabled</td>
        <td>Assertions disabled</td>
    </tr>
</thead>
<tbody>
    <tr>
        <td>Run from source</td>
        <td>Assertions ON</td>
        <td>Assertions OFF</td>
    </tr>
    <tr>
        <td>Run from JAR</td>
        <td>Run JAR (assert ON)</td>
        <td>Run JAR (assert OFF)</td>
    </tr>
</tbody>
</table>

## Dependencies

From `pom.xml`

- `org.jetbrains.annotations`: 26.0.2-1
- `org.junit.jupiter`: 6.0.1
