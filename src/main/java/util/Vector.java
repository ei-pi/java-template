package util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Vector {
    private double x;

    public double getX() { return x; }

    public void setX(final double x) {
        assert !Double.isNaN(x);
        this.x = x;
    }

    private double y;

    public double getY() { return y; }

    public void setY(final double y) {
        assert !Double.isNaN(y);
        this.y = y;
    }

    public Vector(final double x, final double y) {
        assert !Double.isNaN(x);
        assert !Double.isNaN(y);

        this.x = x;
        this.y = y;
    }

    /**
     * {@code Vector(const Vector&)}
     *
     * @param vector To copy from. Not modified
     */
    @Contract(pure = true)
    public Vector(final @NotNull Vector vector) {
        this.x = vector.x;
        this.y = vector.y;
    }

    /**
     * {@code Vector& operator+=(const Vector&)}
     * <p>
     * Modifies {@code this}
     *
     * @param other To increment this vector by. Not modified
     * @return {@code this}
     */
    @Contract(mutates = "this")
    public Vector increment(final @NotNull Vector other) {
        this.x += other.x;
        this.y += other.y;
        return this;
    }

    /**
     * {@code Vector& operator+(const Vector&) const}
     * <p>
     * Doesn't modify {@code this}
     *
     * @param other To add to this vector by. Not modified
     * @return New vector instance with the sum
     */
    @Contract(pure = true)
    public Vector add(final @NotNull Vector other) {
        return new Vector(this.x + other.x, this.y + other.y);
    }

    /**
     * {@code Vector& operator-=(const Vector&)}
     * <p>
     * Modifies {@code this}
     *
     * @param other To increment this vector by. Not modified
     * @return {@code this}
     */
    @Contract(mutates = "this")
    public Vector decrement(final @NotNull Vector other) {
        this.x -= other.x;
        this.y -= other.y;
        return this;
    }

    /**
     * {@code Vector& operator-(const Vector&) const}
     * <p>
     * Doesn't modify {@code this}
     *
     * @param other To add to this vector by. Not modified
     * @return New vector instance with the sum
     */
    @Contract(pure = true)
    public Vector sub(final @NotNull Vector other) {
        return new Vector(this.x - other.x, this.y - other.y);
    }

    /**
     * {@code Vector& operator*=(double)}
     *
     * @param scale Scale factor
     *              <p>
     *              Modifies {@code this}
     * @return {@code this}
     */
    @Contract(mutates = "this")
    public Vector scaleSelf(final double scale) {
        assert !Double.isNaN(scale);
        this.x *= scale;
        this.y *= scale;
        return this;
    }

    /**
     * {@code Vector& operator*(double) const}
     *
     * @param scale Scale factor
     *              <p>
     *              Doesn't modify {@code this}
     * @return {@code this}
     */
    @Contract(pure = true)
    public Vector scale(final double scale) {
        assert !Double.isNaN(scale);
        return new Vector(this.x * scale, this.y * scale);
    }

    /**
     * Normalizes this vector, returning the length it had before
     * normalization
     * <p>
     * Modifies {@code this}
     */
    @Contract(mutates = "this")
    public double normalize() {
        final double length = this.length();
        this.x /= length;
        this.y /= length;
        return length;
    }

    /**
     * Returns a new vector which is the normalized version of this one.
     * <p>
     * Doesn't modify {@code this}
     */
    @Contract(pure = true)
    public Vector toNormalized() {
        final Vector out = new Vector(0, 0);
        this.toNormalized(out);
        return out;
    }

    /**
     * Normalizes this vector, returning the length it had before
     * normalization and writing the result into an out parameter
     * <p>
     * Doesn't modify {@code this}
     *
     * @param out Vector to write the normalized result to
     */
    @Contract(mutates = "param")
    public double toNormalized(final @NotNull Vector out) {
        final double length = this.length();
        out.x = this.x / length;
        out.y = this.y / length;
        return length;
    }

    @Contract(pure = true)
    public double squaredLength() {
        return this.x * this.x + this.y * this.y;
    }

    @Contract(pure = true)
    public double length() {
        return Math.sqrt(this.squaredLength());
    }

    /**
     * Performs a dot product between this vector and another
     *
     * @param other The other vector. Not modified
     */
    @Contract(pure = true)
    public double dot(final @NotNull Vector other) {
        return this.x * other.x + this.y * other.y;
    }

    // the Clonable api sucks
    @Contract(pure = true)
    public Vector copy() {
        return new Vector(this);
    }

    @Override
    @Contract(value = "null -> false", pure = true)
    public boolean equals(final Object obj) {
        return obj instanceof final Vector vector
            && this.x == vector.x && this.y == vector.y;
    }
}
