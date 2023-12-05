package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.Rental;
import com.tobeto.rentacar.repositories.RentalRepository;
import com.tobeto.rentacar.services.abstracts.RentalService;
import com.tobeto.rentacar.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.rentacar.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.rentacar.services.dtos.rental.responses.GetListRentalResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalManager implements RentalService {
    private final RentalRepository rentalRepository;

    public RentalManager(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public void add(AddRentalRequest addRentalRequest){
        Rental rental = new Rental();
        rental.setDate(addRentalRequest.getDate());
        rentalRepository.save(rental);
    }

    @Override
    public void update(UpdateRentalRequest updateRentalRequest){
        Rental rentalToUpdate = rentalRepository.findById(updateRentalRequest.getId()).orElseThrow();
        rentalToUpdate.setDate(updateRentalRequest.getDate());
        rentalRepository.save(rentalToUpdate);
    }

    @Override
    public void delete(int id){
        Rental rentalToDelete = rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(rentalToDelete);
    }

    @Override
    public List<GetListRentalResponse> findByIdentity(int id){
        return rentalRepository.findByIdentity(id)
                .stream()
                .map((Rental) -> new GetListRentalResponse(Rental.getId(), Rental.getDate())).toList();
        // return rentalRepository.findByIdentity(id);
    }

    @Override
    public List<GetListRentalResponse> findAllByOrderByIdDesc(){
        return rentalRepository.findAllByOrderByIdDesc();
    }
}
