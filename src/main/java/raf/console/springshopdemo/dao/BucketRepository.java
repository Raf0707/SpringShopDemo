package raf.console.springshopdemo.dao;

import raf.console.springshopdemo.domain.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketRepository extends JpaRepository<Bucket, Long> {
}

