package ar.edu.itba.sds_2021_q1_g02.models;

import java.util.Set;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class Particle {
    private final int id;
    private final Radius radius;
    private Position position;
    private Velocity velocity;
    private Type type;
    private final Set<Particle> neighbors;

    public Particle(int id, Radius radius, Position position, Velocity velocity, Type type) {
        this.id = id;
        this.radius = radius;
        this.position = position;
        this.velocity = velocity;
        this.neighbors = new HashSet<>();
        this.type = type;
    }

    public int getId() {
        return this.id;
    }

    public Radius getRadius() {
        return this.radius;
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

    public Type getProperty() {
        return this.type;
    }

    public void setProperty(Type property) {
        this.type = property;
    }

    public Collection<Particle> getNeighbors() {
        return this.neighbors;
    }

    public Type getType() {
        return this.type;
    }

    public Particle copy() {
        Particle particle = new Particle(this.id, this.radius, this.position, this.velocity, this.type);

        if (this.position != null)
            particle.setPosition(this.position.copy());
        if (this.velocity != null)
            particle.setVelocity(this.velocity.copy());

        return particle;
    }

    public double distanceTo(Particle other) {
        //TODO: Check if radius must be considered or not
        return (this.getPosition().distanceTo(other.getPosition()) - this.getRadius().getCurrentRadius()) - other.getRadius().getCurrentRadius();
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