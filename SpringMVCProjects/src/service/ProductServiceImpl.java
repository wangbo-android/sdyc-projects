package service;

import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService{

	public void view(Long id) {
		
		System.out.println(id);
	}
}
