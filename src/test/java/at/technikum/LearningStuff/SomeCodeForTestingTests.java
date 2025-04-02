package at.technikum.LearningStuff;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SomeCodeForTestingTests {
    @Test
    void shouldReturnTrueWithInput1() {
        assertTrue(SomeCodeForTesting.m1(1));
        assertFalse(SomeCodeForTesting.m1(2));
    }

    @Test
    void shouldReturnFbelow60() {
        assertEquals('F', SomeCodeForTesting.calculateGrade(30));
    }

    // simulating the user input (example from chatgpt)
    @Test
    void testReadInput() {
        // 1. Save original System.in
        InputStream originalIn = System.in;

        try {
            // 2. Setup test input (simulate user typing "test input")
            String simulatedInput = "test";  // \n for Scanner to read
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

            // 3. Call the method that reads input
            String result = SomeCodeForTesting.handleUserInput();

            // 4. Verify the result
            assertEquals("User typed: test", result);
        } finally {
            // 5. Restore original System.in
            System.setIn(originalIn);
        }
    }

    // simulating the input source
    @Test
    void testUserTypedSomething() {
        InputStream originalIn = System.in;
        // Simulate user typing "hello"
        String simulatedInput = "yo";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);  // Redirect System.in to use simulated input

        // Call the method under test
        String result = SomeCodeForTesting.handleUserInput();

        // Check if the result matches the expected output
        assertEquals("User typed: " + simulatedInput, result);
    }

    @Test
    void assertThrows() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SomeCodeForTesting.calculateGrade(-1);
        });

    }

    ;

    // parameterized test. tests multiple inputs automatically
    @ParameterizedTest
    @CsvSource({
            "2, true",  // even number
            "3, false", // odd number
            "10, true",  // even number
            "5, false"  // odd number
    })
    void testIsEven(int input, boolean expected) {
        // Run the method and compare the result with expected
        assertEquals(expected, SomeCodeForTesting.isEven(input));
    }


    // to dynamically generate the test cases for the parameterized test:
    static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(2, true),  // even number
                Arguments.of(3, false), // odd number
                Arguments.of(4, true),  // even number
                Arguments.of(5, false)  // odd number
        );
    }


    @ParameterizedTest
    @MethodSource("provideNumbers")
    void testIsEvenDynamically(int input, boolean expected) {
        assertEquals(expected, SomeCodeForTesting.isEven(input));
    }


    // second example to parameterized tests

    static Stream<Arguments> provideNumbers2() {
        Random random = new Random();
        int[] arr = new int[5];

        // Generate random numbers and store them in an array
        for (int i = 0; i < 5; i++) {
            arr[i] = random.nextInt(20) + 1;
        }

        // Convert array to Stream<Arguments> dynamically
        return Arrays.stream(arr)
                .mapToObj(num -> Arguments.of(num, num % 2 == 0)); // Check if even
    }

    @ParameterizedTest
    @MethodSource("provideNumbers2")
    void testIsEvenDynamically2(int input, boolean expected) {
        assertEquals(expected, SomeCodeForTesting.isEven(input));
    }


    // testing the speed of a function
    void slowFunction() {
        try {
            Thread.sleep(50); // Simulated delay of 50ms
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Test
    void testExecutionTime() {
        assertTimeout(Duration.ofMillis(100), () -> slowFunction());
        // assertTimeout(Duration.ofMillis(100), this::slowFunction); this version is called "method reference" with douuble colons
    }

    // If you want to interrupt execution when it takes too long, use assertTimeoutPreemptively. This is not always safe, as it may cause resource leaks in multi-threaded applications.


    // Database mocking
    /*
    @Test
    void testDatabaseQuery() {
        Database db = mock(Database.class);
        when(db.getUserName(1)).thenReturn("Alice");

        assertEquals("Alice", db.getUserName(1));
    }
*/

    // to temporarily disable a test case
    @Disabled
    @Test
    void testDisabledFeature() {
        fail("This feature is not ready yet.");
    }
}
