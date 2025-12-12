public class main {

    // ================= VEHICLE =================
    abstract static class Vehicle {
        String licensePlate;
        VehicleType type;

        Vehicle(String licensePlate, VehicleType type) {
            this.licensePlate = licensePlate;
            this.type = type;
        }
    }

    static class Car extends Vehicle {
        Car(String licensePlate) {
            super(licensePlate, VehicleType.CAR);
        }
    }

    static class Bike extends Vehicle {
        Bike(String licensePlate) {
            super(licensePlate, VehicleType.BIKE);
        }
    }

    enum VehicleType {
        CAR, BIKE
    }

    // ================= PARKING SPOT =================
    static class ParkingSpot {
        int spotNumber;
        VehicleType spotType;
        Vehicle parkedVehicle; // null = empty

        ParkingSpot(int spotNumber, VehicleType type) {
            this.spotNumber = spotNumber;
            this.spotType = type;
        }

        boolean isEmpty() {
            return parkedVehicle == null;
        }

        boolean canFit(Vehicle v) {
            return v.type == this.spotType;
        }

        void park(Vehicle v) {
            this.parkedVehicle = v;
        }

        void unpark() {
            this.parkedVehicle = null;
        }
    }

    // ================= TICKET =================
    static class Ticket {
        int ticketId;
        Vehicle vehicle;
        int spotNumber;

        Ticket(int ticketId, Vehicle v, int spotNumber) {
            this.ticketId = ticketId;
            this.vehicle = v;
            this.spotNumber = spotNumber;
        }
    }

    // ================= PARKING LOT =================
    static class ParkingLot {
        java.util.List<ParkingSpot> spots = new java.util.ArrayList<>();
        int ticketCounter = 1;

        ParkingLot() {
            // 3 car spots
            spots.add(new ParkingSpot(1, VehicleType.CAR));
            spots.add(new ParkingSpot(2, VehicleType.CAR));
            spots.add(new ParkingSpot(3, VehicleType.CAR));

            // 2 bike spots
            spots.add(new ParkingSpot(4, VehicleType.BIKE));
            spots.add(new ParkingSpot(5, VehicleType.BIKE));
        }

        Ticket parkVehicle(Vehicle v) {
            for (ParkingSpot spot : spots) {
                if (spot.isEmpty() && spot.canFit(v)) {
                    spot.park(v);
                    Ticket t = new Ticket(ticketCounter++, v, spot.spotNumber);
                    System.out.println("Vehicle parked at spot: " + spot.spotNumber);
                    return t;
                }
            }

            System.out.println("No space available for: " + v.type);
            return null;
        }

        void unparkVehicle(Ticket ticket) {
            for (ParkingSpot spot : spots) {
                if (spot.spotNumber == ticket.spotNumber) {
                    spot.unpark();
                    System.out.println("Vehicle unparked from spot: " + spot.spotNumber);
                    return;
                }
            }
        }
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        ParkingLot lot = new ParkingLot();

        Vehicle car1 = new Car("MH-12-1234");
        Vehicle car2 = new Car("MH-12-5678");
        Vehicle bike1 = new Bike("MH-14-9999");

        Ticket t1 = lot.parkVehicle(car1);
        Ticket t2 = lot.parkVehicle(car2);
        Ticket t3 = lot.parkVehicle(bike1);

        lot.unparkVehicle(t1);
    }
}
