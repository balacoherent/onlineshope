package com.example.E_commerce.Controller;

import com.example.E_commerce.BaseReponse.BaseResponse;
import com.example.E_commerce.DTO.DeliveryDTO;
import com.example.E_commerce.Entity_or_Model.Delivery;
import com.example.E_commerce.Service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/create")
    public BaseResponse createDelivery(@RequestBody DeliveryDTO deliveryDTO) {
        BaseResponse<Delivery> baseResponse;
        baseResponse = BaseResponse.<Delivery>builder().data(deliveryService.createDelivery(deliveryDTO)).build();
        return baseResponse;
    }

    @GetMapping("/get/{deliveryID}")
    public BaseResponse<Optional<Delivery>> findByOrderId(@PathVariable Long deliveryId) {
        BaseResponse<Optional<Delivery>> baseResponse;
        baseResponse = BaseResponse.<Optional<Delivery>>builder().data(deliveryService.findByDeliveryId(deliveryId)).build();
        return baseResponse;
    }

    @GetMapping("/getAll")
    public BaseResponse<List<Delivery>> getAll() {
        BaseResponse<List<Delivery>> baseResponse;
        baseResponse = BaseResponse.<List<Delivery>>builder().data(deliveryService.getAll()).build();
        return baseResponse;
    }

    @PutMapping("/update")
    public BaseResponse<Optional<Delivery>> updateDelivery(@RequestBody DeliveryDTO deliveryDTO) {
        BaseResponse<Optional<Delivery>> baseResponse;
        baseResponse = BaseResponse.<Optional<Delivery>>builder().data(deliveryService.updateDelivery(deliveryDTO)).build();
        return baseResponse;
    }

    @PutMapping("/delete")
    public BaseResponse<Optional<Delivery>> deleteDelivery(@RequestBody DeliveryDTO deliveryDTO) {
        BaseResponse<Optional<Delivery>> baseResponse;
        baseResponse = BaseResponse.<Optional<Delivery>>builder().data(deliveryService.deleteDelivery(deliveryDTO)).build();
        return baseResponse;
    }
}
