package dev.jstec.dsmeta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import dev.jstec.dsmeta.entities.Sale;
import dev.jstec.dsmeta.repositories.SaleRepository;

@Service
public class SmsService {
	@Autowired
	private SaleRepository repository;

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;

	public void sendSms(Long saleId) {
		
		Sale sale = repository.findById(saleId).get();
			
		String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();
		
		String messages = "Vendedor " + sale.getSellerName() + " foi destaque hein " + date 
							+ " com um total de R$ " + String.format("%.2f", sale.getAmount());

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, messages).create();

		System.out.println(message.getSid());
	}
}