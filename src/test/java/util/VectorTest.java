package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VectorTest {
    @Test
    void Vector() {
        assertDoesNotThrow(() -> new Vector(0, 0));
        assertDoesNotThrow(() -> new Vector(new Vector(3, 4)));

        final Vector vec = new Vector(4, 5);
        final Vector clone = new Vector(vec);

        assertEquals(vec.getX(), clone.getX());
        assertEquals(vec.getY(), clone.getY());
    }

    @Test
    void getX() {
        final Vector vec = new Vector(29, -5);
        assertEquals(29, vec.getX());
    }

    @Test
    void setX() {
        final Vector vec = new Vector(3.2, 55);
        assertEquals(3.2, vec.getX());
        vec.setX(40);
        assertEquals(40, vec.getX());
    }

    @Test
    void getY() {
        final Vector vec = new Vector(-5.2, 2);
        assertEquals(2, vec.getY());
    }

    @Test
    void setY() {
        final Vector vec = new Vector(53.2, 1);
        assertEquals(1, vec.getY());
        vec.setY(-3.2);
        assertEquals(-3.2, vec.getY());
    }

    @Test
    void increment() {
        final Vector vec = new Vector(32.4, -12.2);
        final Vector inc = new Vector(2, 4);
        final Vector res = vec.increment(inc);

        assertSame(vec, res);

        assertEquals(34.4, vec.getX());
        assertEquals(-8.2, vec.getY());

        assertEquals(2, inc.getX());
        assertEquals(4, inc.getY());
    }

    @Test
    void add() {
        final Vector vec = new Vector(-1, 4.2);
        final Vector inc = new Vector(3.4, -0.4);
        final Vector res = vec.add(inc);

        assertNotSame(vec, res);

        assertEquals(-1, vec.getX(), 1e-5);
        assertEquals(4.2, vec.getY(), 1e-5);

        assertEquals(3.4, inc.getX(), 1e-5);
        assertEquals(-0.4, inc.getY(), 1e-5);

        assertEquals(2.4, res.getX(), 1e-5);
        assertEquals(3.8, res.getY(), 1e-5);
    }

    @Test
    void decrement() {
        final Vector vec = new Vector(35, -3);
        final Vector dec = new Vector(5, 5);
        final Vector res = vec.decrement(dec);

        assertSame(vec, res);

        assertEquals(30, vec.getX());
        assertEquals(-8, vec.getY());

        assertEquals(5, dec.getX());
        assertEquals(5, dec.getY());
    }

    @Test
    void sub() {
        final Vector vec = new Vector(-12.3, 53.2);
        final Vector dec = new Vector(12, -2.4);
        final Vector res = vec.sub(dec);

        assertNotSame(vec, res);

        assertEquals(-12.3, vec.getX());
        assertEquals(53.2, vec.getY());

        assertEquals(12, dec.getX());
        assertEquals(-2.4, dec.getY());

        assertEquals(-24.3, res.getX());
        assertEquals(55.6, res.getY());
    }

    @Test
    void scaleSelf() {
        final Vector vec = new Vector(2.4, -3);
        final double scaleFactor = 3;
        final Vector res = vec.scaleSelf(scaleFactor);

        assertSame(vec, res);

        assertEquals(7.2, vec.getX(), 1e-5);
        assertEquals(-9, vec.getY(), 1e-5);
    }

    @Test
    void scale() {
        final Vector vec = new Vector(-4, 2);
        final double scaleFactor = 2.5;
        final Vector res = vec.scale(scaleFactor);

        assertNotSame(vec, res);

        assertEquals(-4, vec.getX());
        assertEquals(2, vec.getY());

        assertEquals(-10, res.getX());
        assertEquals(5, res.getY());
    }

    @Test
    void normalize() {
        final Vector vec = new Vector(3, 4);
        final double length = vec.normalize();

        assertEquals(5, length);

        assertEquals(0.6, vec.getX(), 1e-5);
        assertEquals(0.8, vec.getY(), 1e-5);
    }

    @Test
    void toNormalizedVec() {
        final Vector vec = new Vector(5, -4);
        final Vector normalized = vec.toNormalized();

        assertNotSame(vec, normalized);

        assertEquals(5, vec.getX());
        assertEquals(-4, vec.getY());

        assertEquals(0.7808688094, normalized.getX(), 1e-5);
        assertEquals(-0.6246950746, normalized.getY(), 1e-5);
    }

    @Test
    void toNormalizedDouble() {
        final Vector vec = new Vector(-0.5, 1.2);
        final Vector out = new Vector(0, 0);
        final double length = vec.toNormalized(out);

        assertEquals(1.3, length, 1e-5);

        assertEquals(-0.5, vec.getX());
        assertEquals(1.2, vec.getY());

        assertEquals(-0.3846153846, out.getX(), 1e-5);
        assertEquals(0.9230769231, out.getY(), 1e-5);
    }

    @Test
    void squaredLength() {
        final Vector vec = new Vector(-2, 5);
        assertEquals(29, vec.squaredLength());
    }

    @Test
    void length() {
        final Vector vec = new Vector(3.2, -6);
        assertEquals(6.8, vec.length(), 1e-5);
    }

    @Test
    void dot() {
        final Vector vec1 = new Vector(1, 0);
        final Vector vec2 = new Vector(0, 1);
        final Vector vec3 = new Vector(1, 3);
        final Vector vec4 = new Vector(-3, 1);
        final Vector vec5 = new Vector(0, -1);
        final Vector vec6 = new Vector(2, 0);

        assertEquals(0, vec1.dot(vec2));
        assertEquals(0, vec3.dot(vec4));
        assertEquals(0, vec5.dot(vec6));
        assertEquals(-1, vec2.dot(vec5));
        assertEquals(4, vec6.dot(vec6));

        assertTrue(vec1.dot(vec3) > 0d);
        assertTrue(vec1.dot(vec4) < 0d);
    }

    @Test
    void copy() {
        final Vector vec = new Vector(-3, 5.3);
        final Vector clone = new Vector(vec);

        assertEquals(-3, vec.getX());
        assertEquals(5.3, vec.getY());

        assertEquals(vec.getX(), clone.getX());
        assertEquals(vec.getY(), clone.getY());
    }

    @Test
    void testEquals() {
        final Vector vec1 = new Vector(6, -4);
        final Vector vec2 = new Vector(0, 0);
        final Vector vec3 = new Vector(vec1);

        assertNotEquals(null, vec1);
        assertNotEquals(new Object(), vec1);
        assertNotEquals(vec2, vec1);
        assertEquals(vec3, vec1);
    }
}
