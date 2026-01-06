import org.jetbrains.annotations.Contract;

public final class Main {
    private Main() { }

    @Contract(pure = true)
    public static boolean assertionsEnabled() {
        boolean assertionsOn = false;
        // noinspection AssertWithSideEffects
        assert assertionsOn = true; // intentional side-effect
        return assertionsOn;
    }

    // static constant => typically inlined by jvm, and no method call => better perf
    public static final boolean ASSERTIONS_ENABLED = assertionsEnabled();

    public static void main(final String[] args) {
        printEnvInfo();
    }

    private static void printEnvInfo() {
        System.out.println("Runtime.version is '" + Runtime.version() + "'");
        System.out.println("Assertions: " + (ASSERTIONS_ENABLED ? "ON" : "OFF"));
    }
}
