package org.zerock.guestbook.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.guestbook.entity.MemoEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemoRepositoryTests {
    @Autowired
    private MemoRepository memoRepository;

    @Test
    void testInsert() {
        IntStream
                .rangeClosed(1, 100)
                .forEach(i -> {
                    MemoEntity memoEntity = MemoEntity.builder()
                            .memoText("Sample...." + i)
                            .build();
                    memoRepository.save(memoEntity);
                });
    }

    @Test
    void testSelect() {
        Long mno = 100L;
        Optional<MemoEntity> result = memoRepository.findById(mno);
        if (result.isPresent()) {
            MemoEntity memoEntity = result.get();
            System.out.println(memoEntity);
        } else {
            System.out.println("empty!!");
        }
    }

    @Test
    void testUpdate() {
        MemoEntity memoEntity
                = MemoEntity.builder()
                .mno(100L)
                .memoText("Update......")
                .build();
        memoRepository.save(memoEntity);
    }

    @Test
    void testDelete() {
        Long mno = 100L;
//        memoRepository.deleteById(mno);
        MemoEntity memoEntity = MemoEntity.builder()
                .mno(99L)
                .build();
        memoRepository.delete(memoEntity);
    }


    @Test
    public void testPageDefault() {
        Pageable pageable
                = PageRequest.of(0, 20);
        Page<MemoEntity> result
                = memoRepository.findAll(pageable);
        System.out.println(result);

        System.out.println("---------------------------------------");

        System.out.println("Total Pages: " + result.getTotalPages()); // 전체 페이지 번호
        System.out.println("Total Count: " + result.getTotalElements()); // 전체 데이터 수
        System.out.println("Page Number: " + result.getNumber()); // 현재 페이지 번호, 0부터 시작

        System.out.println("Page Size: " + result.getSize()); // 페이지 크기

        System.out.println("has next page: " + result.hasNext()); // 다음 페이지 존재 여부

        System.out.println("first page: " + result.isFirst()); // 첫 페이지 여부

        result.get().forEach(memoEntity -> {
            System.out.println(memoEntity);
        });

    }

    @Test
    public void testSort() {
        Sort sort = Sort.by("mno").descending();

        Pageable pageable
                = PageRequest.of(0, 10, sort);

        Page<MemoEntity> result = memoRepository.findAll(pageable);

        result.get().forEach(memo -> System.out.println(memo));
    }

    @Test
    public void testQueryMethod() {
     List<MemoEntity> result = memoRepository.findByMnoBetweenOrderByMnoDesc(10L, 30L);
     result.forEach(memoEntity -> {
         System.out.println(memoEntity);
     });
    }

    @Test
    void testQueryMethod2() {
        Long mno = 50L;
        Optional<MemoEntity> result = memoRepository.findByMno(mno);
        if(result.isPresent()) {
            System.out.println(result.get());
        }
    }

    @Test
    void textQueryMethod3() {
        memoRepository.updateMemoText(2L,
                "UPDATE ......");
    }
}