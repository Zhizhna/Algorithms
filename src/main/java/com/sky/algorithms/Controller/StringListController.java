package com.sky.algorithms.Controller;

import com.sky.algorithms.Impl.ArrayStringList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/list")
public class StringListController {

    private final ArrayStringList list = new ArrayStringList(10);

    @GetMapping("/add")
    public String add(@RequestParam String item) {
        return list.add(item);
    }

    @GetMapping("/addAtIndex")
    public String addAtIndex(@RequestParam int index, @RequestParam String item) {
        return list.add(index, item);
    }

    @GetMapping("/set")
    public String set(@RequestParam int index, @RequestParam String item) {
        return list.set(index, item);
    }

    @GetMapping("/remove")
    public String remove(@RequestParam String item) {
        return list.remove(item);
    }

    @GetMapping("/removeAtIndex")
    public String removeAtIndex(@RequestParam int index) {
        return list.remove(index);
    }

    @GetMapping("/contains")
    public boolean contains(@RequestParam String item) {
        return list.contains(item);
    }

    @GetMapping("/indexOf")
    public int indexOf(@RequestParam String item) {
        return list.indexOf(item);
    }

    @GetMapping("/lastIndexOf")
    public int lastIndexOf(@RequestParam String item) {
        return list.lastIndexOf(item);
    }

    @GetMapping("/get")
    public String get(@RequestParam int index) {
        return list.get(index);
    }

    @GetMapping("/size")
    public int size() {
        return list.size();
    }

    @GetMapping("/isEmpty")
    public boolean isEmpty(String item) {
        return list.isEmpty(item);
    }

    @GetMapping("/clear")
    public void clear() {
        list.clear();
    }

    @GetMapping("/toArray")
    public String[] toArray() {
        return list.toArray();
    }

    @GetMapping("/equals")
    public boolean equals(@RequestParam String[] otherArray) {
        ArrayStringList otherList = new ArrayStringList(otherArray.length);
        for (String item : otherArray) {
            otherList.add(item);
        }
        return list.equals(otherList);
    }
}
