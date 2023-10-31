package ua.burkavtsov.hw7;

public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector crossProducts(Vector other) {
        double crossX = y * other.z - z * other.y;
        double crossY = z * other.x - x * other.z;
        double crossZ = x * other.y - y * other.x;
        return new Vector(crossX, crossY, crossZ);
    }

    public double cosinusAngle(Vector other) {
        double dotProduct = x * other.x + y * other.y + z * other.z;
        double thisLength = getLength();
        double otherLength = other.getLength();
        return dotProduct / (thisLength * otherLength);
    }

    public Vector add(Vector other) {
        return new Vector(x + other.x, y + other.y, z + other.z);
    }

    public Vector subtract(Vector other) {
        return new Vector(x - other.x, y - other.y, z - other.z);
    }

    public static Vector[] genRandomVectors(int n) {
        Vector[] vectors = new Vector[n];
        for (int i = 0; i < n; i++) {
            double randX = Math.random();
            double randY = Math.random();
            double randZ = Math.random();
            vectors[i] = new Vector(randX, randY, randZ);
        }
        return vectors;
    }
}

