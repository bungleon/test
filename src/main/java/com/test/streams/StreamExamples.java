package com.test.streams;

import com.test.model.StreamTestModel;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class StreamExamples {

    public StreamExamples() {
    }

    public void stream1(List<StreamTestModel> streamTestModels){
        streamTestModels.stream()
                .sorted(Comparator.comparingInt(StreamTestModel::getId))
                .forEach(s-> System.out.println(s.toString()));

    }
    public void stream2(List<StreamTestModel> streamTestModels){
        streamTestModels.stream()
                .filter(s-> s.getId()>5 && s.getId()<10)
                .forEach(s-> System.out.println(s.toString()));

    }

    public void stream3(List<StreamTestModel> streamTestModels){
        streamTestModels.stream()
                .filter(ageMoreThan(25))
                .forEach(s-> System.out.println(s.toString()));

    }

    public void stream4(List<StreamTestModel> streamTestModels){

        IntSummaryStatistics statistics = streamTestModels.stream()
                .mapToInt(StreamTestModel::getAge).summaryStatistics();
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());
        System.out.println(statistics.toString());
    }

    public void stream5(List<StreamTestModel> streamTestModels){
        streamTestModels.stream()
                .filter(s-> s.getId()>5 && s.getId()<10)
                .forEach(System.out::println);

    }

    public void stream6(List<StreamTestModel> streamTestModels){
        streamTestModels.stream()
                .filter(s-> s.getId()>5 && s.getId()<10)
                .map(setAge)
                .forEach(System.out::println);

    }

    public void stream7(List<StreamTestModel> streamTestModels){
        streamTestModels.stream()
                .filter(s-> s.getId()>5 && s.getId()<10)
                .forEach(consumer);

    }

    public void stream8(List<Supplier<StreamTestModel>> streamTestModels){
        streamTestModels.add(supplier);
        System.out.println(streamTestModels.get(0).get());
    }

    public void stream9(List<StreamTestModel> streamTestModels){
        streamTestModels.add(unaryOperator.apply(new StreamTestModel(1000,"","",100)));
        streamTestModels.stream()
                .filter(s-> s.getId()==1000)
                .forEach(s-> System.out.println("Unary "+s.toString()));
        streamTestModels.add(binaryOperator.apply(new StreamTestModel(1000,"","",100),new StreamTestModel(1000,"","",100)));
        streamTestModels.stream()
                .filter(s-> s.getAge()==200)
                .forEach(s-> System.out.println("Binary "+s.toString()));
        streamTestModels.add(biFunction.apply(255,"Erman ÖZ"));
        streamTestModels.stream()
                .filter(s->s.getId()==255)
                .forEach(s-> System.out.println("BiFunction "+s.toString()));
    }


    public void stream10(List<StreamTestModel> streamTestModels){
        StreamTestModel st=new StreamTestModel(2,"","",2);
        streamTestModels.stream()
                .filter(s->biPredicate.test(s,st))
                .forEach(s-> System.out.println("BiPredicate "+s.toString()));
    }

    public void stream11(List<StreamTestModel> streamTestModels){
        streamTestModels.stream()
                .map(s->mycomponent.get1(s))
                .forEach(s-> System.out.println("myCustomFunctionalInterface "+s.toString()));
    }
    public void stream12(List<StreamTestModel> streamTestModels){
        List<StreamTestModel> newstream= streamTestModels.stream()
                .filter(s->s.getId()>8)
                .collect(Collectors.toList());
        for(StreamTestModel s:newstream){
            System.out.println("After stream "+s.toString());
        }
    }
    public void stream13(){
        System.out.println(IComponent.name());
    }

    private Predicate<StreamTestModel> ageMoreThan(Integer age){
        return p -> p.getAge()>age;
    }
    private BiPredicate<StreamTestModel,StreamTestModel> biPredicate=(s1,s2)->{
        return s1.getId()==s2.getId();
    };
    private  Function<StreamTestModel,StreamTestModel> setAge=new Function<StreamTestModel, StreamTestModel>() {
        @Override
        public StreamTestModel apply(StreamTestModel streamTestModel) {
            Random random=new Random();
            streamTestModel.setAge(random.nextInt(100)+5);
            return streamTestModel;
        }
    };
    private Consumer<StreamTestModel> consumer= System.out::println;

    private Supplier<StreamTestModel> supplier=()->createStreamTestModel();

    private UnaryOperator<StreamTestModel> unaryOperator= (id) -> {
        return createStreamTestModel(id);
    };
    private BinaryOperator<StreamTestModel> binaryOperator=(s1,s2)->{
      StreamTestModel s=new StreamTestModel(0,"","",0);
      s.setAge(s1.getAge()+s2.getAge());
      return s;
    };

    private BiFunction<Integer,String,StreamTestModel> biFunction=(s1,s2)->{
        return new StreamTestModel(s1,s2,"",1);
    };

    private StreamTestModel createStreamTestModel(){
        return new StreamTestModel(1, "fsd", "fsd", 1);
    }
    private StreamTestModel createStreamTestModel(StreamTestModel id){
        return new StreamTestModel(id.getId(), "fsd", "fsd", 1);
    }

    private IComponent<StreamTestModel,StreamTestModel> mycomponent=(t)->{
        t.setId(32768);
        t.setName("my name is custom functional interface");
        t.setAdress("ne adresi beeeeeee");
        return t;
    };

}
