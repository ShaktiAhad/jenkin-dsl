def call(dslScript, folders) {
    print "inside createfolders"

    jobDsl targets: dslScript, additionalParameters: [folders: folders]
}