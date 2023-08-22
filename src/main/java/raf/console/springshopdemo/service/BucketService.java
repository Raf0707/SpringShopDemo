package raf.console.springshopdemo.service;

import raf.console.springshopdemo.domain.Bucket;
import raf.console.springshopdemo.domain.User;
import raf.console.springshopdemo.dto.BucketDto;
import raf.console.springshopdemo.dto.BucketDto;

import java.util.List;

public interface BucketService {
	Bucket createBucket(User user, List<Long> productIds);

	void addProducts(Bucket bucket, List<Long> productIds);

	BucketDto getBucketByUser(String name);

	void commitBucketToOrder(String username);
}
