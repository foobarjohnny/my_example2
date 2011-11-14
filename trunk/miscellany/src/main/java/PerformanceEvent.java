
public enum PerformanceEvent {
    VM_HT_CPU_USAGE_AVERAGE("cpu.usage.average");
    
 PerformanceEvent (String s){
        
    }
 public static void main(String[] args) {
String s = "3387492   3385949   3379144   3370372   3367434   3366598   3368129   3363266   3353977   3349101   3345141   3342198   3334859   3330032   3322998   3313421   3314929   3316400   3310480   3302265   3296345   3290431   3280165   3272721   3268161   3264647   3263598   3261549   3258192   3251621   3255777   3256303   3236303   3231577   3244510   3235125   3206649   3209497   ";
System.out.println(s.replaceAll("\\s{1,7}", ","));
 }
}
