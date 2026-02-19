package StaffFactory;

/// Veterinarian takes care of sick animals and return them to "available" state once cured.<p>
/// Counselor takes care of animals in the "Pending" state. Counselor works with adopters.<p>
/// Technicians work with animals in the "Intake" state. Techs inspect animals for potential sickness.
/// If sick then the Tech hands the animal to Vet, otherwise the animal becomes available.
public enum StaffRole {
    VETERINARIAN, TECHNICIAN, COUNSELOR
}
