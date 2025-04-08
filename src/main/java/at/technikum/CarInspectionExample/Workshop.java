package at.technikum.CarInspectionExample;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Workshop implements Job {
    ArrayList<Worker> workers = new ArrayList<>();
    public Job job;
    private boolean seniorAdded = false;

    public void addWorker(Worker w) {
        workers.add(w);
        if (!seniorAdded) {
            String type = nameExtractorFormatter(w.getClass().getName());
            if (type.equals("Senior Worker")) {
                seniorAdded = true;
            }
        }
    }

    public void printReport() {
        // separating the irrelevant parts of the name (which is like path)
        String jobName = nameExtractorFormatter(job.getClass().getName());
        int jobHours = job.getHours();
        int basePrice = job.getBasePrice();
        int minNumberOfWorkers = job.getMinNumberOfWorkers();
        int numberOfCurrentWorkers = workers.size();
        boolean status = numberOfCurrentWorkers >= minNumberOfWorkers;
        double staffCost = 0;

        System.out.println("Workshop Report");
        System.out.println("Job: " + jobName);
        System.out.println("Number of workers required: " + minNumberOfWorkers);
        System.out.println("Number of actual workers: " + numberOfCurrentWorkers);
        System.out.println();
        System.out.println("Hours needed: " + jobHours);
        System.out.println();
        System.out.println("Price:");
        for (Worker w : workers) {
            double workerHours = (double) jobHours / (double) workers.size();
            int hourlyRate = w.getHourlyRate();
            staffCost += hourlyRate * workerHours;
            String type = nameExtractorFormatter(w.getClass().getName());
            System.out.printf(
                    "%s (%s) %.2f x %d%n",
                    type,
                    w.getName().trim(),
                    workerHours,
                    hourlyRate
            );
        }
        System.out.println("----------");
        System.out.printf("--> %.2f%n", (staffCost + basePrice));


        if (status && seniorAdded) {
            System.out.println("Status: possible");
        } else {
            System.out.println("Status: not possible");
            if (status) {
                System.out.println("1 senior worker required");
            } else if (seniorAdded) {
                System.out.println("More workers needed");
            }
        }


    }

    // zusätzlich von mir
    private static String nameExtractorFormatter(String str) {
        String[] a = str.split("\\.");
        String s = a[a.length - 1];
        // separate words (could probably be coded much simpler...)
        Pattern p = Pattern.compile("([A-Z][a-z]+)");
        Matcher m = p.matcher(s);
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            sb.append(m.group()).append(" ");
        }
        return sb.toString().trim();
    }

    public void setJob(Job ci) {
        this.job = ci;
    }

    @Override
    public int getMinNumberOfWorkers() {
        return 0;
    }

    @Override
    public int getBasePrice() {
        return 0;
    }

    @Override
    public int getHours() {
        return 0;
    }
}

// for main
/*        Workshop w = new Workshop();
        w.addWorker(new SeniorWorker("Tom"));
        w.addWorker(new JuniorWorker("Tina"));
        w.addWorker(new JuniorWorker("Tanya"));

        w.setJob(new CarInspection(new Audi(1999)));

        w.printReport();*/