package ar.edu.itba.sds_2021_q1_g02.models;

import java.util.Set;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class Particle {
    private final int id;
    private final double minRadius;
    private final double maxRadius;
    private final Set<Particle> neighbors;
    private Position position;
    private Velocity velocity;

    public Particle(int id, double minRadius, double maxRadius, Position position, Velocity velocity) {
        this.id = id;
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
        this.neighbors = new HashSet<>();
        this.position = position;
        this.velocity = velocity;
    }

    public int getId() {
        return this.id;
    }

    public double getMinRadius() {
        return this.minRadius;
    }

    public double getMaxRadius() {
        return this.maxRadius;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Velocity getVelocity() {
        return this.velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    public Collection<Particle> getNeighbors() {
        return this.neighbors;
    }

    public Particle copy() {
        Particle particle = new Particle(this.id, this.minRadius, this.maxRadius, this.position, this.velocity);

        if (this.position != null)
            particle.setPosition(this.position.copy());
        if (this.velocity != null)
            particle.setVelocity(this.velocity.copy());

        return particle;
    }

    public double distanceTo(Particle other) {
        return (this.getPosition().distanceTo(other.getPosition()) - this.getMinRadius()) - other.getMaxRadius();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Particle)) return false;
        Particle particle = (Particle) o;
        return this.getId() == particle.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}