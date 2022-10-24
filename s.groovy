def call(dslScript = "seed_folder.groovy", folders) {
    print "inside createfolders"

    jobDsl targets: dslScript, additionalParameters: [folders: folders]
}