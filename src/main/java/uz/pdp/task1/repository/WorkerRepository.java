package uz.pdp.task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.task1.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    boolean existsByPhoneNumber(String phoneNumber);

    // UZIDAN TASHQARI TELEFON RAQAMLARNI TEKSHIRADI
    boolean existsByPhoneNumberAndIdNot(String phoneNumber, Integer id);
}
