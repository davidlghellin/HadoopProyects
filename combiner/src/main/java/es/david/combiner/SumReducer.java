package es.david.combiner;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    protected void reduce(Text pKey, Iterable<IntWritable> pValues, Context pContext)
            throws IOException, InterruptedException {
        int wordCount = 0;
        for (IntWritable value : pValues) {
            wordCount += value.get();
        }
        pContext.write(pKey, new IntWritable(wordCount));
    }

}
