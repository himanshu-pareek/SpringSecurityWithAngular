package com.example.springangularfrontendserver.controller;

import java.security.Principal;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("banking")
public class BankingController {

    // GET /banking/transfer?account=Bob&amount=100
    @GetMapping("transfer")
    public Map<String, Object> transfer(
        Principal user,
        @RequestParam Map<String, String> params
    ) {
        String from = user.getName();
        String to = params.get("account");
        Integer amount = Integer.parseInt(params.get("amount"));

        System.out.printf("Sending $%d from %s to %s\n", amount, from, to);

        return Map.of(
            "from", from,
            "to", to,
            "amount", amount
        );
    }

    // POST /banking/transfer
    //
    // {
    //      "account": "Bob",
    //      "amount": 100
    //  }
    @PostMapping("transfer")
    public Map<String, Object> transferPost(
        Principal user,
        @RequestBody Map<String, String> body
    ) {
        String from = user.getName();
        String to = body.get("account");
        Integer amount = Integer.parseInt(body.get("amount"));

        System.out.printf("Sending %d from %s to %s using POST request\n", amount, from, to);

        return Map.of(
            "from", from,
            "to", to,
            "amount", amount
        );
    }
}
