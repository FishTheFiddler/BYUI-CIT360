package WesJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


class MassEffectCharacterTest {

    @Test
    void assertArrayEqualsTest() {
        MassEffectCharacter shepard = new MassEffectCharacter("Shepard", "Human", 1, true, new char[]{'E', 'a', 'r','t','h'});
        MassEffectCharacter jacob = new MassEffectCharacter("Jacob", "Human", 2, true, new char[]{'E', 'a', 'r','t','h'});
        assertArrayEquals(shepard.getHomePlanet(), jacob.getHomePlanet(), "Characters are from different planets.");
    }

    @Test
    void assertEqualsTest() {
        MassEffectCharacter shepard = new MassEffectCharacter("Shepard", "Human", 1, true, new char[]{'E', 'a', 'r','t','h'});
        assertEquals("Shepard", shepard.getName(), "Character name doesn't match.");
        assertEquals("Human", shepard.getSpecies(), "Character species doesn't match.");
    }

    @org.junit.jupiter.api.Test
    void assertFalseTest() {
        MassEffectCharacter tali = new MassEffectCharacter("Tali", "Quarian", 1, false, new char[]{'E', 'a', 'r','t','h'});
        assertFalse(tali.getIsMale(), "This character is supposed to be female.");
    }

    @org.junit.jupiter.api.Test
    void assertTrueTest() {
        MassEffectCharacter tali = new MassEffectCharacter("Tali", "Quarian", 1, false, new char[]{'E', 'a', 'r','t','h'});
        MassEffectCharacter garrus = new MassEffectCharacter("Garrus", "Turian", 1, true, new char[]{'P', 'a', 'l','a','v','e','n'});

        assertTrue(garrus.getIsMale(), "This character is supposed to be male.");
        //assertTrue(tali.getIsMale(), "This character is supposed to be male.");
    }

    @Test
    void assertNotNullTest() {
        MassEffectCharacter grunt = new MassEffectCharacter("Grunt", "Krogan", 2, true, new char[]{'T', 'u', 'c','h','a','n','k', 'a'});
        assertNotNull(grunt.getName(),"Variable is Null");
        assertNotNull(grunt.getSpecies(),"Variable is Null");
        assertNotNull(grunt.getAppearance(),"Variable is Null");
        assertNotNull(grunt.getIsMale(),"Variable is Null");
    }

    @Test
    void assertNullTest() {
        MassEffectCharacter legion = new MassEffectCharacter("Legion", null, 2, true, null);
        assertNull(legion.getSpecies(),"Variable is NOT Null");

    }

    @org.junit.jupiter.api.Test
    void assertNotSameTest() {
        MassEffectCharacter shepard = new MassEffectCharacter("Shepard", "Human", 1, true, new char[]{'E', 'a', 'r','t','h'});
        MassEffectCharacter ashley = new MassEffectCharacter("Ashley", "Human", 1, false, new char[]{'E', 'a', 'r','t','h'});
        assertNotSame(shepard.getIsMale(), ashley.getIsMale(), "These characters are the same gender.");
    }


    @org.junit.jupiter.api.Test
    void assertSameTest() {
        MassEffectCharacter james = new MassEffectCharacter("James", "Human", 3, true, new char[]{'E', 'a', 'r','t','h'});
        MassEffectCharacter miranda = new MassEffectCharacter("Miranda", "Human", 2, false, new char[]{'E', 'a', 'r','t','h'});
        assertSame(james.getSpecies(), miranda.getSpecies(), "These characters are not the same species gender.");
    }

    @org.junit.jupiter.api.Test @Disabled ("\"assertThat()\" has been depreciated in JUnit5.  Last known version was JUnit 4.")
    void assertThatTest() {
        MassEffectCharacter mordin = new MassEffectCharacter("Mordin", "Salarian", 2, true, new char[]{'S', 'u', 'r','k','e','s','h'});
        //assertThat(T actual, Matcher<T> matcher)
    }
}
