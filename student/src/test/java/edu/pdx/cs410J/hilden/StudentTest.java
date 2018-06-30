package edu.pdx.cs410J.hilden;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Unit tests for the Student class.  In addition to the JUnit annotations,
 * they also make use of the <a href="http://hamcrest.org/JavaHamcrest/">hamcrest</a>
 * matchers for more readable assertion statements.
 */
public class StudentTest {

    @Test
    public void studentNamedPatIsNamedPat() {
        String name = "Pat";
        var pat = new Student(name, new ArrayList<>(), 0.0, "Doesn't matter");
        assertThat(pat.getName(), equalTo(name));
    }

    @Test(expected = IllegalArgumentException.class)
    public void gpaMustBeLessThanOrEqualToFourPointZero() {
        createStudentWithGpa(4.1);
    }

    @Test
    public void aFourPointZeroGpaIsPossible()
    {
        createStudentWithGpa(4.0);
    }

    private void createStudentWithGpa(double gpa) {
        new Student("??", new ArrayList<>(), gpa, "Doesn't matter");
    }
}
